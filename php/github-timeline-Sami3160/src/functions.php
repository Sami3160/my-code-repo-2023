<?php

/**
 * Generate a 6-digit numeric verification code.
 */
function generateVerificationCode(): string
{
  // TODO: Implement this function
  return strval(rand(100000, 999999));
}

/**
 * Send a verification code to an email.
 */
function sendVerificationEmail(string $email, string $code): bool
{
  // TODO: Implement this function

  $subject = "Your Verification Code";
  $message = "<p>Your verification code is: <strong>$code</strong></p>";
  $headers = "From: no-reply@example.com\r\n";
  $headers .= "Content-Type: text/html\r\n";

  return mail($email, $subject, $message, $headers);
}

// their was no function to implement send email for unsubscribe, so made new one
function sendUnsubVerificationEmail(string $email, string $code): bool
{
  $subject = "Confirm Unsubscription";
  $message = "<p>To confirm unsubscription, use this code: <strong>$code</strong></p>";
  $headers = "From: no-reply@example.com\r\n";
  $headers .= "Content-Type: text/html\r\n";

  return mail($email, $subject, $message, $headers);
}

function emailExists(string $email): bool
{
  $file = __DIR__ . "/registered_emails.txt";
  $emails = file_exists($file) ? file($file, FILE_IGNORE_NEW_LINES) : [];
  return in_array($email, $emails);
}

/**
 * Register an email by storing it in a file.
 */
function registerEmail(string $email): bool
{
  $file = __DIR__ . "/registered_emails.txt";
  // TODO: Implement this function

  // $file = __DIR__ . '/registered_emails.txt';
  // $emails= file_exists($file) ? file($file, FILE_IGNORE_NEW_LINES) : [];
  if (!emailExists($email)) {
    file_put_contents($file, $email . "\n", FILE_APPEND);
    return true;
  } else {
    return false;
  }
}

/**
 * Unsubscribe an email by removing it from the list.
 */
function unsubscribeEmail(string $email): bool
{
  $file = __DIR__ . "/registered_emails.txt";
  if (emailExists($email)) {
    $emails = file($file, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    // $index=array_search( $email, $emails);
    $emails = array_filter($emails, fn($ele) => trim($ele) != trim($email));
    file_put_contents($file, implode(PHP_EOL, $emails));
    return true;
  } else {
    return false;
  }
  // TODO: Implement this function
}

/**
 * Fetch GitHub timeline.
 */

function fetchGitHubTimeline()
{
  // TODO: Implement this function
  $url = "https://www.github.com/timeline";
  $curl = curl_init();
  curl_setopt_array($curl, [
    CURLOPT_URL => $url,
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_ENCODING => "",
    CURLOPT_MAXREDIRS => 10,
    CURLOPT_TIMEOUT => 0,
    CURLOPT_FOLLOWLOCATION => true,
    CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
    CURLOPT_CUSTOMREQUEST => "GET",
  ]);

  $response = curl_exec($curl);
  curl_close($curl);
  if (!$response) {
    return [];
  }
  $data = simplexml_load_string($response);
  $timeline=[];
  foreach ($data as $key => $value) {
    if ($key == "entry") {
      $event=explode("Event/", substr($value->id, 20))[0];
      $name=$value->author->name;
      array_push($timeline, array($event, $name));
    }
  }
  return $timeline;
}

/**
 * Format GitHub timeline data. Returns a valid HTML sting.
 */
function formatGitHubData(array $data): string
{
  // TODO: Implement this function
  $formatedData="<h2>GitHub Timeline Updates</h2><table border='1'>
  <tr><th>Event</th><th>User</th></tr>
  ";
  foreach ($data as $key => $value) {
    $formatedData=$formatedData."<tr><td>".$value[0]."</td><td>".$value[1]."</td></tr>";
  }
  $formatedData=$formatedData."</table><p><a href='unsubscribe_url' id='unsubscribe-button'>Unsubscribe</a></p>";
  return $formatedData;
}

/**
 * Send the formatted GitHub updates to registered emails.
 */
function sendGitHubUpdatesToSubscribers(): void
{
  $data= fetchGitHubTimeline();
  $message= formatGitHubData($data);
  $subject = "Latest GitHub Updates";
  $headers = "From: no-reply@example.com\r\n";
  $headers .= "Content-Type: text/html\r\n";

  $file = __DIR__ . "/registered_emails.txt";
  $emails=file_exists($file) ? file($file, FILE_IGNORE_NEW_LINES) : [];
  foreach ($emails as $key => $value) {
    mail(trim($value), $subject, $message, $headers);
  }
  // TODO: Implement this function
}
