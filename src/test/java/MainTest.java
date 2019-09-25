import com.test.jdbc.entity.UserEntity;
import com.test.jdbc.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {

    @Test
    public void MainTest() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = Mockito.mock(ResultSet.class); //создаем mock для ResultSet
        Mockito.when(resultSet.next()).thenReturn(true);

        Statement statement = Mockito.mock(Statement.class); //создаем mock для Statement
        Mockito.when(statement.executeQuery("SELECT * FROM users WHERE login = \"Dandy\"")).thenReturn(resultSet);

        Connection connection = Mockito.mock(Connection.class); //создаем mock для Connection
        Mockito.when(connection.createStatement()).thenReturn(statement);

        UserRepository userRepository = Mockito.mock(UserRepository.class);

        UserEntity userEntity = Mockito.mock(UserEntity.class);

        UserEntity userEntity1 = UserEntity.builder()
                .login("Dandy")
                .firstName("Danil")
                .secondName("Ishutin")
                .middleName("Alexandrovich")
                .age(29)
                .email("dandy@gmail.com")
                .phoneNumber("+79166242162")
                .build();

        when(userRepository.findByLogin("Dandy")).thenReturn(userEntity);
        Assert.assertEquals(userEntity.getLogin(), userEntity1.getAge());

//        when(mock.findByLogin("Dandy")).thenReturn(UserEntity.builder()
//                .login("Dandy")
//                .firstName("Danil")
//                .secondName("Ishutin")
//                .middleName("Alexandrovich")
//                .age(29)
//                .email("dandy@gmail.com")
//                .phoneNumber("+79166242162")
//                .build());
//
//        Assert.assertEquals(userEntity.getAge(), 29);
//        when(statement.executeQuery("SELECT * FROM users WHERE login = \"Dandy\"")).then(resultSet);

//        when(resultSet.getString("login")).then("Dandy")
//        when(connection.createStatement()).thenReturn(statement); //связываем connection и statement
//        String sql = "SELECT * FROM users WHERE login = \" Dandy \"";
//        when(statement.executeQuery(sql)).thenReturn(resultSet); //связываем statement и resultSet
//        when(resultSet.next()).thenReturn(false);//задаем поведение для resultSet
//
//        UserEntity testUserEntity = UserRepository.findByLogin("Dandy")
//
//
//        UserEntity userEntity = UserEntity.builder()
//                .login("Dandy")
//                .firstName("Danil")
//                .secondName("Ishutin")
//                .middleName("Alexandrovich")
//                .age(29)
//                .email("dandy@gmail.com")
//                .phoneNumber("+79166242162")
//                .build();

    }
}