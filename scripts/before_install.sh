FILE=/home/ubuntu/app/startup.json
if test -f "$FILE"; then
   echo "$FILE exists"
   cd /home/ubuntu/
   pm2 delete 0
   killall -9 node
else 
    echo "$FILE does not exist."
fi
cd /home/ubuntu/
sudo rm -rf app
mkdir app