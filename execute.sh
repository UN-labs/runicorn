docker-compose -f runicorn-compose.yml up&
source test.sh
echo "done"
open http://127.0.0.1:8080
open http://127.0.0.1:8080/test/
docker-compose -f runicorn-compose.yml down

