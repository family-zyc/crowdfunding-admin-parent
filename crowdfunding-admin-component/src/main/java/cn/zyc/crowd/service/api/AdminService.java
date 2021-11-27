package cn.zyc.crowd.service.api;

import cn.zyc.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyc
 * @date 2021/11/25
 */
public interface AdminService {
    void saveAdmin(Admin admin);


    List<Admin> getAll();

    Admin getAdminByLoginAcct(Admin admin);

    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);
}
