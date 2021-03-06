package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.ActionResult;
import com.example.demo.dao.entity.ActionResultExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface ActionResultMapper {
	@Update("update action_result set is_right=#{isRight} where result_id=#{resultId}")
	int updateIsRight(int resultId,int isRight);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    long countByExample(ActionResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int deleteByExample(ActionResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int deleteByPrimaryKey(Integer resultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int insert(ActionResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int insertSelective(ActionResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    List<ActionResult> selectByExample(ActionResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    ActionResult selectByPrimaryKey(Integer resultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int updateByExampleSelective(@Param("record") ActionResult record, @Param("example") ActionResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int updateByExample(@Param("record") ActionResult record, @Param("example") ActionResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int updateByPrimaryKeySelective(ActionResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_result
     *
     * @mbg.generated Mon Apr 11 21:41:01 CST 2022
     */
    int updateByPrimaryKey(ActionResult record);
}