//Java Script for number guesser game.
//Author: Chris Owen

//Number input text box id= numInput
//Guess button needs to call the guess() function
//option box id = difficulty

//if in doubt take this form as a template. (I used this to develop the JS)
//  <form name="game" id="gameform">
//    <input type="text" id="numInput" name="numInput" value=""><br>
//    <input type="button" value="Guess" onclick="guess()">
//    <select id="difficulty">
//      <option value="Easy">Easy</option>
//      <option value="Medium">Medium</option>
//      <option value="Hard">Hard</option>
//    </select>
//  </form>

//Global Variables
var randomNumber = 0;
var guessedNumber = 0;
var numberOfGuesses = 0;
var maxNumOfGuesses = 0;



function guess() {
  //Check if its a new game, if it is then generate a randomNumber!
  if (numberOfGuesses == 0) {
    //generate the number between 0-100 and round it to an int.
    randomNumber = Math.round(Math.random() * 100);
    //Print it to the console. (DEBUG ONLY)
    console.log(randomNumber);
  }

  //Get the difficulty from the option box and determine the current index
  var x = document.getElementById("difficulty").selectedIndex;
  //use that index to get the content of the option box
  switch (document.getElementsByTagName("option")[x].value) {
    case "Easy":
    //if the difficulty is easy then set the max number of guesses to 10
      maxNumOfGuesses = 10;
      break;
    case "Medium":
    //if the difficulty is medium then set the max number of guesses to 6
      maxNumOfGuesses = 6;
      break;
    case "Hard":
    //if the difficulty is hard then set the max number of guesses to 4
      maxNumOfGuesses = 4;
      break;
  }
  //Print the number of guesses to the console.
  console.log("maxNumOfGuesses = " + maxNumOfGuesses);

  //Get the guess from the user.
  guessedNumber = parseInt(document.getElementById("numInput").value);
  console.log("guessedNumber = " + guessedNumber);

  //Check whether the player is out of guesses
  if (numberOfGuesses == maxNumOfGuesses) {
    //if so tell them how bad they are.
    alert("You have lost");
    numberOfGuesses = 0;
  }
  else {
    // if not add one to the guess counter
    numberOfGuesses += 1;
    console.log("numberOfGuesses = " + numberOfGuesses);

    //Add in something to show the user their guesses. Maybe a list?


    //Check the number.
    if (guessedNumber < randomNumber) {
      //Do something to show the correct number is higher

      alert("Number is higher");

    }
    else if (guessedNumber > randomNumber) {
      //do something to show that the number is lower

      alert("Number is lower");
    }
    else if (guessedNumber == randomNumber) {
      //Do something to show that the number is correct.

      alert("GG");
      numberOfGuesses = 0;
    }
  }
}
