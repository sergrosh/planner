#!/usr/bin/env bash
# shell script required to make use of variable expansion
exec java -Xms900m -Xmx900m -jar /app/planner-latest.jar "$@"
