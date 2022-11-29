# Задача №1 по теме Исключения, Stacktrace.
## "Проверка доступа к ресурсу".
### Описание.

#### В этом задании мы напишем программу для проверки доступа к ресурсу. Во время запуска программы нужно запросить логин или пароль пользователя. Если один из введеных параметров не совпадает (логин/пароль), то нужно выбросить checked исключение UserNotFoundException. Если возраст пользователя менее 18 лет, то нужно выбросить исключение AccessDeniedException, а если 18 и больше лет - вывести сообщение "Доступ предоставлен".  
Массив пользователей для авторизации нужно описать до запуска программы. Каждая запись пользователя содержит поля: login, password, age (возраст) и email.

### Функционал программы.
1. Создание Scanner для чтения логина и пароля пользователя из консоли;
2. Создание checked исключения UserNotFoundException;
3. Создание checked исключения AccessDeniedException;
4. Выбрасывать ошибку UserNotFoundException, если логин или пароль введены не верно;
5. Выбрасывать ошибку AccessDeniedException, если возраст пользователя меньше 18 лет;
6. Если ошибок не возникло, вывести сообщение "Доступ предоставлен".
#
### Процесс реализации.
1. Создал класс User, в котором хранится инфомрация о пользавателе: login, password, email, age;

~~~ public class User {
    private String passWord;
    private String login;
    private int age;
    private String email;

    public User(String passWord, String login, int age, String email){
        this.passWord = passWord;
        this.login = login;
        this.age = age;
        this.email = email;
    }
    public String getLogin(){
        return login;
    }
    public String getPassWord(){
        return passWord;
    }
    public int getAge(){
        return age;
    }
}
~~~
2. Создал класс исключение UserNotFoundException на основе базового класса Exception. Это исключение будем использовать, если пользователь ввел неверный логин или пароль:


~~~ public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
~~~
3. Аналогичным образом создал класс исключения AccessDeniedException
~~~ public class AccessDeniedException extends Exception{
    public AccessDeniedException(String message) {
        super(message);
    }
}
~~~
4. В классе Main создал метод getUsers, этот метод должен возвращать список заранее созданных пользователей:
~~~ 
public static User[] getUsers() {
        User user1 = new User("666", "Gorila", 24, "gorila@icloud.com");
        User user2 = new User("4444", "Boy12", 15, "boy12@icloud.com");
        User user3 = new User("3333", "Girl134", 30, "girl34@icloud.com");
        User user4 = new User("9999", "denn", 10, "den100@icloud.com");

        return new User[]{user1, user2, user3, user4};
    }
~~~
5. Создаk в классе Main метод getUserByLoginAndPassword(String login, String password), в этом методе нужно найти соответствие пары логина и пароля пользователя из массива, возвращаемого методом getUsers. Если пользователь не найден, выбрасываем исключение UserNotFoundException, если найден - возвращаем найденного пользователя:
~~~
 public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassWord().equals(password)) {
              return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }
~~~
6. Создал к классу Main еще один метод validateUser для проверки возрастра пользователя. Если возраст менее 18 лет, метод должен выбросить исключение AccessDeniedException.
~~~
 public static void validateUser(User user) throws AccessDeniedException {
        if(user.getAge() > 18){
            System.out.println("Welcome " + user.getLogin());
            return;
        }
         throw new AccessDeniedException("пользователю меньше 18 лет");
    }
~~~
7. импортировал и создал объект типа Scanner.
8. В методе main запрашивал логин и пароль пользователя, программа проверяла наличие данной пары логин и пароль, а так же возрас пользователя.
~~~
public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        validateUser(getUserByLoginAndPassword(login, password));
        System.out.println("Доступ предоставлен");

    }
~~~
- При наличии верной пары логин и пароль и возраст более 18 лет в консоль выводится "Доступ предоставлен".
- При наличии верной пары логин и пароль и возраст менее 18 лет выбрасывается исключение AccessDeniedException и сообщение "пользователю менне 18 лет".
- При отсутствии верной пары логин и пароль ивыбрасывается исключение UserNotFoundException и сообщение "User not found".







