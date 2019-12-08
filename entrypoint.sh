#!/bin/sh
CSMOPTS=()
whitespace="[[:space:]]"
for i in "$@"
do
    if [[ $i =~ $whitespace ]]
    then
        CSMOPTS+=(\"$i\")
    else
        CSMOPTS+=($i)
    fi
done

java -jar mkvroomba.jar -tessdata /tessdata ${CSMOPTS[@]}"
