# Banking CLI Application

## Описание проекта

Эта программа предназначена для выполнения традиционных банковских операций через командную строку. Пользователь может создавать счета, пополнять их, снимать деньги и получать информацию о всех счетах. Программа реализована с использованием принципов `SOLID` и чистой архитектуры.

## Функциональность

- **Создание счета** (CHECKING, SAVING, FIXED)
- **Пополнение счета**
- **Снятие денег со счета**
- **Получение информации о всех счетах**
- **Получение информации о всех трансферах**

  ## Создание базу данных PostgreSQL:

   ```sql
   -- Создание базы данных
   CREATE DATABASE Account;

   -- Подключение к базе данных
   \c Account;

   -- Создание последовательности для уникальных идентификаторов
   CREATE SEQUENCE account_new_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

   -- Создание таблицы account
   CREATE TABLE account (
       id VARCHAR PRIMARY KEY DEFAULT nextval('account_new_id_seq'::regclass),
       clientid VARCHAR NOT NULL,
       balance DOUBLE PRECISION NOT NULL,
       withdrawallowed VARCHAR NOT NULL,
       accounttype VARCHAR NOT NULL
   );

   -- Создание таблицы transaction
   CREATE TABLE transaction (
       transactionid VARCHAR PRIMARY KEY DEFAULT nextval('transaction_new_id_seq'::regclass),
       accountid VARCHAR NOT NULL REFERENCES account(id),
       transactiontype VARCHAR NOT NULL
   );
   ```



## Команды и Пример использования

```
 Welcome to CLI bank service Enter operation number:
1 - show account
2 - create account
3 - deposit
4 - withdraw
5 - transfer
6 - exit
```

- **Показать аккаунты:**
  ```
  1
  Account ID: 3
  Client ID: 4
  Balance: 0.0
  Withdraw Allowed: true
  Account Type: SAVING
  ```
- **Создать аккаунт:**
- ```
  2
  1 - SAVING
  2 - FIXING
  3 - CHECKING

  2
  The account has been successfully created!!!
  ```

  **Пополнить счет**:

  ```
  3
  Enter account number
  2
  Enter the amount of money
  500
  Replenishment of funds has been completed successfully!!!
  ```

  **Снять деньги со счета**:

  ```
  4
  Enter account number
  2
  Enter the amount of money
  100
  Replenishment of funds has been completed successfully!!!
  
  4
  Enter account number
  9
  Enter the amount of money
  100
  You have a fixed account. You can't send money
  
  4
  Enter account number
  3
  Enter the amount of money
  100000
  You don't have enough money!!
  ```

  **Показать все трансферы**

  ```
  5
  Transaction ID: 2
  Account id: 1
  Transaction Type: DEPOSIT
  Transaction amount: 100.0
  -------------------------
  ```

  **Выйти**

  ```
  6
  Application Closed
  ```

## Аннотации и автоматическая конфигурация

В проекте используется Spring Framework для автоматической конфигурации компонентов с помощью аннотаций Component и Autowired. Lombok используется для сокращения шаблонного кода. Все конфигурации написаны в классе `ApplicationConfiguration`

## Неиспользованная функциональность

В ходе реализации проекта были упущены некоторые моменты, которые изначально планировались:

1. **Инициализация через XML** : В проекте не используется инициализация через `XML`. Вместо этого используется автоматическая конфигурация с помощью аннотаций Spring.
2. **Использование List** : В проекте не используется `List` для DAO. Вместо этого используется `PostgreSQL` и все запросы написаны через `Jdbc Template`.
3. **DAO** : Некоторые методы не используется и изменено некоторые методы. Например: `getClientAccounts` принимает только accountID.

## Изменения и дополнения

### Новые классы и методы

- **Transaction**: Класс, представляющий транзакцию. Необходим для работы с историей операций по счетам.
- **TransactionType**: Enum, представляющий типы транзакций (например, DEPOSIT, WITHDRAW).
- **ApplicationConfiguration**: Класс, отвечающий за конфигурацию приложения. Используется для настройки зависимостей и автоматической конфигурации с помощью Spring.

### Корректировка методов

- **AccountDepositServiceImpl**: Метод `deposit` теперь принимает объект типа `Account`, а не `AccountWithdraw`.
- **TransactionWithdraw**: Метод `execute` был изменен для корректной работы с параметрами.
- **TransactionDeposit**: Метод `execute` был изменен для корректной работы с параметрами.

### Изменения в DAO

- Добавлены и изменены методы в DAO для поддержки новых классов и корректной работы с базой данных.

### Обновления UML диаграммы

В процессе разработки были внесены изменения, которые не были отражены в изначальной UML диаграмме:

1. **Отсутствие классов**: Классы `Transaction`, `TransactionType` и `ApplicationConfiguration` не были включены в изначальную диаграмму, но они необходимы для работы приложения.
2. **Корректировка методов**: Методы в классах `TransactionWithdraw`, `TransactionDeposit` и `AccountDepositServiceImpl` были изменены для корректной работы с параметрами и бизнес-логикой.
3. **Изменения в DAO**: Были добавлены и изменены методы в DAO для поддержки новых классов и операций с базой данных.

Эти изменения улучшили функциональность и гибкость приложения, сделав его более надежным и удобным в использовании.
