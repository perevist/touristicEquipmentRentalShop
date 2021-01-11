package com.projectIO.touristicEquipmentRentalShop.services.implementations;

import com.ocadotechnology.gembus.test.Arranger;
import com.projectIO.touristicEquipmentRentalShop.dao.interfaces.CustomerDAO;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceImplTest {

    @Mock
    private CustomerDAO customerDAO;
    @InjectMocks
    private RegistrationServiceImpl registrationService;

    /////////////////////////////////////////////////////////
    // testy - sprawdzanie czy jeden z parametrów jest pusty
    /////////////////////////////////////////////////////////
    @Test
    @DisplayName("1. Test - login is empty")
    void shouldThrowExceptionIfLoginIsEmpty() {
        // given
        String login = "";
        String firstName = Arranger.someText(1, 15);
        String lastName = Arranger.someText(1, 15);
        String phoneNumber = Arranger.somePositiveInt(999999999).toString();
        String email = Arranger.someEmail();
        String passsword = Arranger.someText(1, 15);
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }

    @Test
    @DisplayName("1. Test - firstName is empty")
    void shouldThrowExceptionIfFirstNameIsEmpty() {
        // given
        String login = Arranger.someText(1, 15);
        String firstName = "";
        String lastName = Arranger.someText(1, 15);
        String phoneNumber = Arranger.somePositiveInt(999999999).toString();
        String email = Arranger.someEmail();
        String passsword = Arranger.someText(1, 15);
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }

    @Test
    @DisplayName("1. Test - lastName is empty")
    void shouldThrowExceptionIfLastNameIsEmpty() {
        // given
        String login = Arranger.someText(1, 15);
        String firstName = Arranger.someText(1, 15);
        String lastName = "";
        String phoneNumber = Arranger.somePositiveInt(999999999).toString();
        String email = Arranger.someEmail();
        String passsword = Arranger.someText(1, 15);
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }

    @Test
    @DisplayName("1. Test - phoneNumber is empty")
    void shouldThrowExceptionIfPhoneNumberIsEmpty() {
        // given
        String login = Arranger.someText(1, 15);
        String firstName = Arranger.someText(1, 15);
        String lastName = Arranger.someText(1, 15);
        String phoneNumber = "";
        String email = Arranger.someEmail();
        String passsword = Arranger.someText(1, 15);
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }

    @Test
    @DisplayName("1. Test - email is empty")
    void shouldThrowExceptionIfEmailIsEmpty() {
        // given
        String login = Arranger.someText(1, 15);
        String firstName = Arranger.someText(1, 15);
        String lastName = Arranger.someText(1, 15);
        String phoneNumber = Arranger.somePositiveInt(999999999).toString();
        String email = "";
        String passsword = Arranger.someText(1, 15);
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }

    @Test
    @DisplayName("1. Test - passsword is empty")
    void shouldThrowExceptionIfPasswordIsEmpty() {
        // given
        String login = Arranger.someText(1, 15);
        String firstName = Arranger.someText(1, 15);
        String lastName = Arranger.someText(1, 15);
        String phoneNumber = Arranger.somePositiveInt(999999999).toString();
        String email = Arranger.someEmail();
        String passsword = "";
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }


    /////////////////////////////////////////////////////////////////////////
    // testy parametryczne - sprawdzanie czy jeden z parametrów jest null'em
    /////////////////////////////////////////////////////////////////////////
    @DisplayName("2. Test - one of parameter is null")
    @ParameterizedTest(name = "{1}")
    //@ParameterizedTest(name = "{1} - parameters: {0}")
    @MethodSource("inputData")
    void shouldThrowExceptionIfOneOfParameterIsNull(List<String> input, String comment) {
        // given
        String login = input.get(0);
        String firstName = input.get(1);
        String lastName = input.get(2);
        String phoneNumber = input.get(3);
        String email = input.get(4);
        String passsword = input.get(5);
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nalezy podac wszystkie dane potrzebne do rejestracji");
    }

    private static Stream<Arguments> inputData(){
        return Stream.of(
                Arguments.of(Arrays.asList(
                        null, Arranger.someText(1, 15), Arranger.someText(1, 15),
                        Arranger.somePositiveInt(999999999).toString(), Arranger.someEmail(),
                        Arranger.someText(1, 15)), "login is null"),

                Arguments.of(Arrays.asList(
                        Arranger.someText(1, 15), null, Arranger.someText(1, 15),
                        Arranger.somePositiveInt(999999999).toString(), Arranger.someEmail(),
                        Arranger.someText(1, 15)), "firstName is null"),

                Arguments.of(Arrays.asList(
                        Arranger.someText(1, 15), Arranger.someText(1, 15), null,
                        Arranger.somePositiveInt(999999999).toString(), Arranger.someEmail(),
                        Arranger.someText(1, 15)), "lastName is null"),

                Arguments.of(Arrays.asList(
                        Arranger.someText(1, 15), Arranger.someText(1, 15), Arranger.someText(1, 15),
                        null, Arranger.someEmail(), Arranger.someText(1, 15)), "phoneNumber is null"),

                Arguments.of(Arrays.asList(
                        Arranger.someText(1, 15), Arranger.someText(1, 15), Arranger.someText(1, 15),
                        Arranger.somePositiveInt(999999999).toString(), null,
                        Arranger.someText(1, 15)), "email is null"),

                Arguments.of(Arrays.asList(
                        Arranger.someText(1, 15), Arranger.someText(1, 15), Arranger.someText(1, 15),
                        Arranger.somePositiveInt(999999999).toString(), Arranger.someEmail(),
                        null), "lastName is null")
        );
    }


    /////////////////////////////////////////////////////////////////////////
    // testy - Mockito - sprawdzanie czy login jest unikalny
    /////////////////////////////////////////////////////////////////////////
    @DisplayName("3. Test - login is not unique")
    @Test
    void shouldThrowExceptionIfLoginIsNotUnique() {
        // given
        String login = Arranger.someText(1, 15);
        String firstName = Arranger.someText(1, 15);
        String lastName = Arranger.someText(1, 15);
        String phoneNumber = Arranger.somePositiveInt(999999999).toString();
        String email = Arranger.someEmail();
        String passsword = Arranger.someText(1, 15);

        Mockito.doThrow(new IllegalArgumentException()).when(customerDAO).save(ArgumentMatchers.any());
        // when
        // then
        assertThatThrownBy(() -> registrationService.registerCustomer(
                login, firstName, lastName, phoneNumber, email, passsword))
                .isInstanceOf(IncorrectLoginException.class)
                .hasMessage("Podany login jest już zajęty");
    }

}