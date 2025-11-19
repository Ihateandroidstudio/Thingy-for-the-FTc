package org.firstinspires.ftc.teamcode.Irrelevant.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Tutorial")
//in the android FTC driver hub "the thing with the screen on it"
// @TeleOp is which category the OpMode/Program is and in the brackets should be name = (name of program)
// it doesn't have to match the name of the class but in this case it does



public class Tutorial extends OpMode {
    //all OpModes/Programs should start with "public class (OpMode/Program Name) extends OpMode"
    //the (OpMode/Program Name) in the public class has to match what the name of the OpMode/Program

    //it will come with an error because we don't have public void loop and public void init
    //they are required for the OpMode to work
    //this is shown below
    //don't really worry about why, they just are


    @Override
    public void init() {
        // void means it doesn't send a output
        // init only runs once
        // usually to reset things and to setup stuff

        telemetry.addData("init", "Completed");
        //telemetry is the thing that shows up on the android
        //addData is a function that adds data to the telemetry
        //the first thing in the parenthesis is the title of the data
        //the second thing is the data itself
        //in this case, the title is "init" and the data is "Completed"
        //it would show up in the telemetry as

        telemetry.update();
        //update is a function that updates the telemetry
        //you need to update the telemetry for it to show up on the android
        //you can have multiple addData in one init, but you only need one update

        //this should print on the telemetry as "init:Completed"


    }

    @Override
    public void loop() {
        //loop is pretty self explanatory like init, it just keeps on running after you init
        //so this is where you should be putting in your code to do an action

        telemetry.addData("loop", "is running");
        telemetry.update();
        //this should print on the telemetry as "loop:is running"
        //make sure you are updating the telemetry after you change it

        if (gamepad1.a) {
            telemetry.addData("Gamepad1", "is being pressed");
            telemetry.update();
            //if statements are a way to check if something is true or false
            //in this case, it is checking if the "A" button on gamepad1 is pressed
            //if it is pressed, it will run the code inside the if statement
            //in this case it will print on the telemetry "Gamepad1:is being pressed"
            //if it is not pressed, it will not run the code inside the if statement

        }
        else {
            telemetry.addData("Gamepad1", "is not being pressed");
            telemetry.update();
            //else statements are a way to run code if the if statement is false
            //in this case, it will print on the telemetry "Gamepad1:is not being pressed"
            //because the "A" button can only be off or on there is no need for another if statement to check if its not being pressed
            //unless you want to check multiple buttons which is usually what happens in most practical OpModes/Programs
            //but that is for another tutorial called IfElse
        }
    }

}
