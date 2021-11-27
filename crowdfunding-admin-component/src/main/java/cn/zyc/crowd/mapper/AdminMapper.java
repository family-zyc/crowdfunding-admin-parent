package cn.zyc.crowd.mapper;

import cn.zyc.crowd.entity.Admin;
import cn.zyc.crowd.entity.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAdminByKeyword(String keyword);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbggenerated Wed Nov 24 16:17:31 CST 2021
     */
    int updateByPrimaryKey(Admin record);
}