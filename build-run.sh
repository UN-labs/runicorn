docker build . --tag runicorn
docker run -it -p 3000:3000 runicorn