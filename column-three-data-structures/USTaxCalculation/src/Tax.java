
public class Tax 
{
	/*
	 * For the sake of this example, 6 tax-brackets are considered.
	 * The original problem has 25 tax-brackets.
	 */
	private static final int[] TAX_BRACKETS = {2200, 2700, 3200, 3700, 4200, 4700};
	private static final double[] PERCENT = {0.0, .14, .15, .16, .17, .18};
	private static final int[] BASE_TAX = {0, 0, 70, 145, 225, 270};
	private static final int MAX_INCOME = TAX_BRACKETS[TAX_BRACKETS.length - 1];
	private static final int LIMIT = TAX_BRACKETS.length;
	
	public static float findTax(int income) throws IllegalIncomeException
	{
		if(income > MAX_INCOME || income < 0)
			throw new IllegalIncomeException("Income has to be below " + MAX_INCOME);
		int pos = position(income);
		assert(pos != -1);

		if(pos == 0)
		{
			return 0;
		}
		
		else
		{
			float tax = (float) (BASE_TAX[pos] + (PERCENT[pos] * (income - TAX_BRACKETS[pos - 1])));
			return tax;
		}
		
	}
	
	private static int position(int income)
	{
		for(int i = 0; i < LIMIT; i++)
		{
			if(income <= TAX_BRACKETS[i])
			{
				return i;
			}
		}
		return -1;
	}
	
}
