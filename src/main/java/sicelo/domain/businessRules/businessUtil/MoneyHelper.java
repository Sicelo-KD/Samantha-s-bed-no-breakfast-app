package sicelo.domain.businessRules.businessUtil;

import sicelo.domain.businessRules.businessUtil.DateHelper;

public class MoneyHelper {
    /**
     *
     */

    private static final float CONSTANT = 100;
    private static final float NUMBER_OF_MONTHS = 12;

    @Deprecated
    /**
     * {@Deprecated} Moneyhelper Should focus on Money / Currency issues Not Business Rules
     * */
    public static long getIntAmount(){
        return (long) ((DateHelper.DAY_OF_YEAR + CONSTANT) / NUMBER_OF_MONTHS);
    }
}
