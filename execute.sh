docker-compose -f runicorn-compose.yml up&
source test.sh
echo "done"
docker-compose -f runicorn-compose.yml down
open -na "Google Chrome" --args --incognito http://127.0.0.1:3000/test &>/dev/null
google-chrome --incognito http://127.0.0.1:3000/test& &>/dev/null
open -na "Google Chrome" --args --incognito http://127.0.0.1:3000/target/site/surefire-report.html &>/dev/null
google-chrome --incognito http://127.0.0.1:3000/target/site/surefire-report.html& &>/dev/null
npm install
npm start

