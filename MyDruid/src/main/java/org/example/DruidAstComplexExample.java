package org.example;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOperator;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.expr.SQLIntegerExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

public class DruidAstComplexExample {
    public static void main(String[] args) {
        String sql = "SELECT id, name, age FROM users WHERE status = 'active'";

        SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, JdbcConstants.MYSQL);
        List<SQLStatement> stmtList = parser.parseStatementList();
        SQLStatement stmt = stmtList.get(0);

        if (stmt instanceof SQLSelectStatement) {
            SQLSelectStatement selectStatement = (SQLSelectStatement) stmt;
            SQLSelectQueryBlock queryBlock = selectStatement.getSelect().getQueryBlock();

            // 现有的WHERE子句
            SQLExpr where = queryBlock.getWhere();

            // 创建新的条件 "age > 20"
            SQLBinaryOpExpr newCondition = new SQLBinaryOpExpr(
                    new SQLIdentifierExpr("age"),
                    SQLBinaryOperator.GreaterThan,
                    new SQLIntegerExpr(20)
            );

            // 将新条件与现有条件通过AND连接
            SQLBinaryOpExpr combinedCondition = new SQLBinaryOpExpr(
                    where,
                    SQLBinaryOperator.BooleanAnd,
                    newCondition
            );

            queryBlock.setWhere(combinedCondition);

            // 输出修改后的SQL
            System.out.println(selectStatement.toString());
        }
    }
}
