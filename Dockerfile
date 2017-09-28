FROM node
RUN mkdir /src
WORKDIR /src
COPY . /src
RUN npm install

CMD npm test