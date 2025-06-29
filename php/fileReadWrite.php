<?php
$filename = "sample.txt";
$contentToWrite = "Hello, this is a sample file.\nSecond line of text.";

// ----------- Writing to the file -----------
$file = fopen($filename, "w"); // 'w' = write mode, creates file if not exists
if ($file) {
    fwrite($file, $contentToWrite);
    fclose($file);
    echo "File written successfully.<br>";
} else {
    echo "Error writing to the file.<br>";
}

// ----------- Reading from the file -----------
$file = fopen($filename, "r"); // 'r' = read mode
if ($file) {
    echo "<strong>File Contents:</strong><br>";
    while (($line = fgets($file)) !== false) {
        echo nl2br($line); // Converts \n to <br> for browser output
    }
    fclose($file);
} else {
    echo "Error reading the file.<br>";
}
?>
