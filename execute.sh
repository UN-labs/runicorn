sudo npm install -g allure-commandline
npm install
sudo rm -rf test/cucumber/allure-report/
sudo rm -rf test/cucumber/test/reports/allure-results/
docker-compose -f runicorn-compose.yml up&
sudo npm install yarn -g
sudo npm install webdriverio -g
sudo npm install wdio-json-reporter -g
sudo npm install wdio-spec-reporter -g
sudo npm install wdio-mocha-framework -g
sudo npm install wdio-allure-reporter -g
#wdio test/at/wdio.conf.js
cd test/cucumber/
npm install webdriverio
npm install wdio-cucumber-framework
yarn install
yarn run wdio
allure generate test/reports/allure-results/ --clean
#source test.sh
#echo "done"
cd ../../
docker-compose -f runicorn-compose.yml down
open -na "Google Chrome" --args --incognito http://127.0.0.1:3000/test &>/dev/null
google-chrome --incognito http://127.0.0.1:3000/test& &>/dev/null
open -na "Google Chrome" --args --incognito http://127.0.0.1:3000/test/cucumber/allure-report &>/dev/null
google-chrome --incognito http://127.0.0.1:3000/test/cucumber/allure-report& &>/dev/null
npm start
rm -rf allure-report/

