<?php
require_once "functions.php";
// TODO: Implement the form and logic for email registration and verification
session_start();
$message = "";
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if (isset($_POST["email"])) {
    $email = trim($_POST["email"]);
    if(emailExixts($email)){
      $message="Email already registred!";
    }else if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $code = generateVerificationCode();

      $_SESSION["verification_email"] = $email;
      $_SESSION["verification_code"] = $code;


      if (sendVerificationEmail($email, $code)) {
        $message ="A verification code has been sent to " . htmlspecialchars($email);
      } else {
        $message = "Failed to send verification email. Please try again.";
      }
    } else {
      $message = "Invalid email format.";
    }
  }
}

if (isset($_POST["verification_code"])) {
  $codeInput = trim($_POST["verification_code"]);
  if (
    !isset($_SESSION["verification_code"]) ||
    !isset($_SESSION["verification_email"])
  ) {
    $message = "Please submit your email first.";
  } elseif ($codeInput == $_SESSION["verification_code"]) {

    if(registerEmail($_SESSION['verification_email'])){
        $message = "Verification done";
    }else{
        $message = "Already registred email!";
    }
    session_unset();
    session_destroy();
  } else {
    $message = "Verification failed!";
  }
}
?>
<html>
 <head>
    <title>Registration forms</title>
 </head>
 <body>
    <?php if (!empty($message)): ?>
        <p><strong><?= $message ?></strong></p>
    <?php endif; ?>
    <h2>Enter your email</h2>
    <form method="POST">
        <input type="email" name="email" required>
        <br>
        <button id="submit-email">Submit</button>
    </form>
    <br>
    <br>

    <h2>Verify code</h2>
    <form method="POST">
        <input type="text" name="verification_code" maxlength="6" required>
        <br>
        <button id="submit-verification">Verify</button>
    </form>
 </body>
</html>
