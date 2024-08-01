package kz.asik.light.cli.myCli;

import kz.asik.light.cli.account.AccountBasicCLI;
import kz.asik.light.cli.transaction.TransactionDepositCLI;
import kz.asik.light.cli.transaction.TransactionWithdrawCLI;
import kz.asik.light.models.account.type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI {
    private final Scanner scanner;
    private  AccountBasicCLI accountBasicCLI;
    private TransactionDepositCLI transactionDepositCLI;
    private TransactionWithdrawCLI transactionWithdrawCLI;
    @Autowired
    public MyCLI(Scanner scanner) {
        this.scanner = scanner;

    }
    @Autowired
    public void setAccountBasicCLI(@Lazy AccountBasicCLI accountBasicCLI) {
        this.accountBasicCLI = accountBasicCLI;
    }
    @Autowired
    public void setTransactionDepositCLI(@Lazy  TransactionDepositCLI transactionDepositCLI) {
        this.transactionDepositCLI = transactionDepositCLI;
    }
    @Autowired
    public void setTransactionWithdrawCLI(@Lazy TransactionWithdrawCLI transactionWithdrawCLI){
        this.transactionWithdrawCLI = transactionWithdrawCLI;
    }
    public void start() {
        System.out.println("Welcome to CLI bank service Enter operation number: \n");
        boolean running = true;
        while (running) {
            System.out.println("1 - show account\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - exit");
            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    accountBasicCLI.getAccounts();
                    System.out.println();
                    break;
                case "2":
                    accountBasicCLI.createAccountRequest();
                    break;
                case "3":
                    transactionDepositCLI.depositMoney();
                    break;
                case "4":
                     transactionWithdrawCLI.withdrawMoney();
                    break;
                case "5":
                    transactionWithdrawCLI.printAllTransaction();
                    case "6":
                    System.out.printf("Application Closed\n");
                    running = false;
                    break;
                default:
                    System.out.printf("Command not recognized!\n");
                    break;
            }
        }
    }


    public double requestClientAmount() {
        System.out.println("Enter the amount of money ");
        double amount = scanner.nextDouble();
        return amount;
    }


    public String requestClientAccountNumber() {
        System.out.println("Enter account number ");
        String accountNumber = scanner.nextLine();
        return accountNumber;
    }

    @Override
    public AccountType requestAccountType() {
        while (true) {
            System.out.println("1 - SAVING");
            System.out.println("2 - FIXING");
            System.out.println("3 - CHECKING");
            String type = scanner.nextLine();
            switch (type) {
                case "1":
                    System.out.println(AccountType.SAVING);
                    return AccountType.SAVING;
                case "2":
                    System.out.println(AccountType.FIXED);
                    return AccountType.FIXED;
                case "3":
                    System.out.println(AccountType.CHECKING);
                    return AccountType.CHECKING;
                default:
                    System.out.println("Неправильный тип. Повторите еще раз !!!");
            }
        }
    }
}
