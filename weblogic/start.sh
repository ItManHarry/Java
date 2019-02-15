nohup ./startWebLogic.sh &
sleep 60
nohup ./bin/startManagedWebLogic.sh web http://localhost:7002 > ./doosvn_domain.log 2>&1 &
