#!/bin/bash
# This script should set up a CRON job to run cron.php every 5 minutes.
# You need to implement the CRON setup logic here.
CRON_CMD="*/5 * * * * php $(pwd)/src/cron.php"
( crontab -l 2>/dev/null | grep -v -F "$CRON_CMD" ; echo "$CRON_CMD" ) | crontab -
echo "CRON job added to run every 5 minutes."