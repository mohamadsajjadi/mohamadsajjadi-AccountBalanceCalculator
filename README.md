# mohamadsajjadi-AccountBalanceCalculator
## بخش اول 
### پرسش اول 
طبق چیزی که در کلاس گفته شد, مقدار حساب نمیتواند منفی باشد. در ازای انجام یکسری Transaction در صورتی که مقدار Withraw از مقدار Deposit بیشتر شود, در کد داده شده, مقدار Balance منفی می‌شود که نباید اینگونه باشد
### پرسش دوم 
آزمون نوشته شده به صورت زیر می‌باشد:
```
    @Test
    void checkNegativeBalanceHistory() {
        // balance can not be less than zero
        int oldBalance = AccountBalanceCalculator.calculateBalance(AccountBalanceCalculator.getTransactionHistory());
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, 100);
        AccountBalanceCalculator.addTransaction(transaction);
        int balance = AccountBalanceCalculator.calculateBalance(AccountBalanceCalculator.getTransactionHistory());
        assertEquals(oldBalance, balance);
    }
```
و برای درست کردن آن به صورت زیر عمل میکنیم:
```
    public static void addTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.WITHDRAWAL) {
            int newBalance = calculateBalance(transactionHistory) - transaction.getAmount();
            if (newBalance < 0){
                System.out.println("Not Enough Credit !");
                return;
            }
        }
        transactionHistory.add(transaction);
    }
```
### پرسش سوم 
 باعث می‌شود آزمون‌ها به صورت جانب‌دارانه طرح شوند(یعنی جوری طراحی شوند که درست کار کنند) و ممکن است خواسته‌های اصلی مصرف‌کننده فراموش شود. پس بهتر است که در ابتدا این آزمون‌ها و بر اساس خواست مصرف‌کننده طراحی شود
