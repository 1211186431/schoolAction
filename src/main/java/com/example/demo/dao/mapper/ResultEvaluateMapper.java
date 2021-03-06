package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.ResultEvaluate;
import com.example.demo.dao.entity.ResultEvaluateExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ResultEvaluateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    long countByExample(ResultEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int deleteByExample(ResultEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int deleteByPrimaryKey(Integer evaluateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int insert(ResultEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int insertSelective(ResultEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    List<ResultEvaluate> selectByExample(ResultEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    ResultEvaluate selectByPrimaryKey(Integer evaluateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int updateByExampleSelective(@Param("record") ResultEvaluate record, @Param("example") ResultEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int updateByExample(@Param("record") ResultEvaluate record, @Param("example") ResultEvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int updateByPrimaryKeySelective(ResultEvaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table result_evaluate
     *
     * @mbg.generated Sun Apr 17 13:43:05 CST 2022
     */
    int updateByPrimaryKey(ResultEvaluate record);
}