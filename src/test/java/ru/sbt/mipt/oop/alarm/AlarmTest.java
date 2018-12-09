package ru.sbt.mipt.oop.alarm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlarmTest {

    private Alarm alarm = new Alarm();


    @Test
    void activateFromDisabledTest() {

        alarm.activate("123456");
        Assertions.assertTrue(alarm.getState() instanceof ActivatedState);
    }

    @Test
    void setToAlarmFromActivatedTest() {
        alarm.activate("123456");
        alarm.setToAlarm();
        Assertions.assertTrue(alarm.getState() instanceof AlertAlarmState);

    }

    @Test
    void activateFromActivatedTest() {
        alarm.activate("123456");
        Assertions.assertTrue(alarm.getState() instanceof ActivatedState);
        alarm.activate("123");
        Assertions.assertTrue(alarm.getState() instanceof AlertAlarmState);
        Assertions.assertTrue(!alarm.checkPasswordConcept("123"));

    }

    @Test
    void activateFromAlarmTest() {
        alarm.activate("123456");
        Assertions.assertTrue(alarm.getState() instanceof ActivatedState);
        alarm.activate("123");
        Assertions.assertTrue(alarm.getState() instanceof AlertAlarmState);
        alarm.activate("12");
        Assertions.assertTrue(alarm.getState() instanceof AlertAlarmState);
        Assertions.assertTrue(!alarm.checkPasswordConcept("12"));

    }

    @Test
    void deactivateFromActivatedWithRightPasswordTest() {
        alarm.activate("123456");
        alarm.deactivate("123456");

        Assertions.assertTrue(alarm.getState() instanceof DisabledAlarmState);
        Assertions.assertTrue(alarm.checkPasswordConcept("0000"));
    }

    @Test
    void deactivateFromActivatedWithWrongPasswordTest() {
        alarm.activate("123456");
        alarm.deactivate("123");

        Assertions.assertTrue(alarm.getState() instanceof AlertAlarmState);
    }

    @Test
    void deactivateFromDeactivatedTest() {
        alarm.deactivate("123");
        Assertions.assertTrue(alarm.getState() instanceof DisabledAlarmState);
        Assertions.assertTrue(alarm.checkPasswordConcept("0000"));
    }

    @Test
    void deactivateFromAlarmTest() {
        alarm.activate("123456");
        alarm.deactivate("123");
        Assertions.assertTrue(alarm.getState() instanceof AlertAlarmState);
        alarm.deactivate("123456");
        Assertions.assertTrue(alarm.getState() instanceof DisabledAlarmState);
        Assertions.assertTrue(alarm.checkPasswordConcept("0000"));
    }

}
