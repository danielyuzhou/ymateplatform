/**
 * <p>文件名:	IDialect.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform-Persistence</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.persistence.jdbc.base.dialect;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>
 * IDialect
 * </p>
 * <p>
 * 数据库方言接口定义类，用于适配不同数据库特性；
 * </p>
 * 
 * @author 刘镇(suninformation@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th><th width="100px">动作</th><th
 *          width="100px">修改人</th><th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>刘镇</td>
 *          <td>2011-8-30下午01:02:44</td>
 *          </tr>
 *          </table>
 */
public interface IDialect {

	/**
	 * @return 返回方言名称
	 */
	public abstract String getDialectName();

	/**
	 * @param sql 原SQL语句
	 * @param limit
	 * @param offset
	 * @return 返回分页SQL语句，默认 null
	 */
	public abstract String getPaginationSql(String sql, int limit, int offset);

	/**
	 * @param statement
	 * @return 返回主键值（按 long 类型返回），采用JDBC Statement对象获取自动生成的主键（仅处理单主键）
	 * @throws SQLException
	 */
	public abstract Object[] getGeneratedKey(Statement statement) throws SQLException;

	/**
	 * @param sequenceName 序列名称
	 * @return 返回获取下一序列值的SQL语句，默认 null
	 */
	public abstract String getSequenceNextValSql(String sequenceName);

}