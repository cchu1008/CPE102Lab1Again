public abstract class BinaryExpression
   implements Expression
{
	private Expression lft;
	private Expression rht;
	private String op;
	
   public BinaryExpression(Expression lft, Expression rht, String op)
   {
	   this.lft = lft;
	   this.rht = rht;
	   this.op = op;
   }
   
   public String toString()
   {
	   return "(" + lft + op + rht + ")";
   }
   
   protected abstract double _applyOperator(double lft, double rht);
   
   public double evaluate(Bindings bindings)
   {
	   return _applyOperator(lft.evaluate(bindings), rht.evaluate(bindings));
   }
}