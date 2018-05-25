#!/bin/bash
USER=$1
PASS=$2
PORT=$3

if [ -z "$PORT" ]; then
	PORT=8443
fi


RESULT=`curl https://localhost:8443/auth/realms/master/protocol/openid-connect/token --data "grant_type=password&client_id=admin-cli&username=$USER&password=$PASS" -k -H "Host: localhost:$PORT" 2>/dev/null`
if [[ $RESULT = *"invalid_grant"* ]];
then
	echo "Invalid credentials !!!"
	exit -1
fi
if [[ $RESULT != *"access_token"* ]];
then
	echo "Unknown error! "
	exit -1
fi

token=`echo $RESULT | sed 's/.*access_token":"//g' | sed 's/".*//g'`
rm TOKEN2 -f
echo $token >> TOKEN2
echo $token
