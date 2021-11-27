package cn.zyc.crowd.service.impl;

import cn.zyc.crowd.constant.CrowdConstant;
import cn.zyc.crowd.entity.Admin;
import cn.zyc.crowd.entity.AdminExample;
import cn.zyc.crowd.exception.LoginFailedException;
import cn.zyc.crowd.mapper.AdminMapper;
import cn.zyc.crowd.service.api.AdminService;
import cn.zyc.crowd.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author zyc
 * @date 2021/11/25
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(null);
    }


    @Override
    public Admin getAdminByLoginAcct(Admin admin) {
        if(admin == null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED );
        }

        // query admin by loginAcct
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAcctEqualTo(admin.getLoginAcct());
        List<Admin> list = adminMapper.selectByExample(adminExample);

        // verify result
        if(list == null || list.size() == 0){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        if(list.size() > 1){
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }

        // check whether the encrypted password is the same as the database password
        Admin resultAdmin = list.get(0);
        String userPswdDB = resultAdmin.getUserPswd();
        String userPswdForm = CrowdUtil.md5(admin.getUserPswd());
        if(!Objects.equals(userPswdDB,userPswdForm)){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        return resultAdmin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        // invoke pageHelper method to implement page function
        PageHelper.startPage(pageNum,pageSize);

        List<Admin> adminList = adminMapper.selectAdminByKeyword(keyword);

        return new PageInfo<>(adminList);
    }


}
