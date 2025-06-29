<?php
require_once "functions.php";
session_start();
$message = "";
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if (isset($_POST["unsubscribe_email"])) {
    $email = trim($_POST["unsubscribe_email"]);
    // if (sendVerificationEmail($email, $code)){
    //     $message = "Verification code sent to $email";
    // }else{
    //     $message = "Eror occured while sending email to $email";
    // }

    if(!emailExists($email)){
        $message="Email is not registered yet!";
    }else if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $code = generateVerificationCode();

      $_SESSION["unsubscribe_email"] = $email;
      $_SESSION["unsubscribe_verification_code"] = $code;


      if (sendUnsubVerificationEmail($email, $code)) {
        $message ="A verification code has been sent to " . htmlspecialchars($email);
      } else {
        $message = "Failed to send verification email. Please try again.";
      }
    } else {
      $message = "Invalid email format.";
    }

    // file_put_contents("src/pending_codes/tempUnverifiedEmails.txt", $code);
  }
}

if (isset($_POST["unsubscribe_verification_code"])) {
  $codeInput = trim($_POST["unsubscribe_verification_code"]);
  if (
    !isset($_SESSION["unsubscribe_verification_code"]) ||
    !isset($_SESSION["unsubscribe_email"])
  ) {
    $message = "Please submit your email first.";
  } elseif ($codeInput == $_SESSION["unsubscribe_verification_code"]) {

    if(unsubscribeEmail($_SESSION['unsubscribe_email'])){
        $message = "Unubscribed!";
    }else{
        $message = "Email not registred yet!";
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
    <title>Unsubscribing forms</title>
 </head>
 <body>
    <?php if (!empty($message)): ?>
        <p><strong><?= $message ?></strong></p>
    <?php endif; ?>
    <h2>Unsubscribe email submission</h2>
    <form method="POST">
    <input type="email" name="unsubscribe_email" required>
    <br>
    <button id="submit-unsubscribe">Unsubscribe</button>
    </form>
    <br>
    <br>

    <h2>Unsubscribe Verify code</h2>
    <form method="POST">
    <input type="text" name="unsubscribe_verification_code">
    <br>
    <button id="verify-unsubscribe">Verify</button>
    </form>
 </body>
</html>
