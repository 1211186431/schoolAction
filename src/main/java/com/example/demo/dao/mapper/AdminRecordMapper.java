package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.AdminRecord;
import com.example.demo.dao.entity.AdminRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdminRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    long countByExample(AdminRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int deleteByExample(AdminRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int deleteByPrimaryKey(Integer recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int insert(AdminRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int insertSelective(AdminRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    List<AdminRecord> selectByExample(AdminRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    AdminRecord selectByPrimaryKey(Integer recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int updateByExampleSelective(@Param("record") AdminRecord record, @Param("example") AdminRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int updateByExample(@Param("record") AdminRecord record, @Param("example") AdminRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int updateByPrimaryKeySelective(AdminRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_record
     *
     * @mbg.generated Sun Apr 03 13:41:10 CST 2022
     */
    int updateByPrimaryKey(AdminRecord record);
}