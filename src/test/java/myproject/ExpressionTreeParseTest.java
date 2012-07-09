package myproject;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class ExpressionTreeParseTest {
	
	private ExpressionTreeParse expressionTreeParse;
	
	@Before
	public void setup() {
		expressionTreeParse = new ExpressionTreeParse();
	}
	
	@Test
	public void shouldParseStringExpressionToPostfixFormat() {
		// Given
		String stringExp = "(5+2)*7";
		// When
		List<String> parsedExp = expressionTreeParse.parse(stringExp);
		// Then
		assertThat(parsedExp.toArray(new String[0]), IsEqual.equalTo(new String[] {"5","2", "+", "7","*"}));
	}
	
	@Test
	public void shouldBuildCorrectBinaryTreeNode() {
		// Given
		String stringExp = "(5+2)*7";
		List<String> parsedExp = expressionTreeParse.parse(stringExp);
		// When
		BinaryTreeNode<String> binaryTreeNode = expressionTreeParse.buildTreeNode(parsedExp);
		// Then
		assertThat(binaryTreeNode.getValue(), IsEqual.equalTo("*"));
		assertThat(binaryTreeNode.getRight().getValue(), IsEqual.equalTo("7"));
		assertThat(binaryTreeNode.getLeft().getValue(), IsEqual.equalTo("+"));
		assertThat(binaryTreeNode.getLeft().getLeft().getValue(), IsEqual.equalTo("5"));
		assertThat(binaryTreeNode.getLeft().getRight().getValue(), IsEqual.equalTo("2"));
	}
	
	@Test
	public void shouldReturnCorrectValueOnExpr() {
		/// Given
		String stringExp = "(5+2)*7";
		// When
		int result = expressionTreeParse.expr(stringExp);
		
		// Then
		assertThat(result, IsEqual.equalTo(49));
		
	}

}
