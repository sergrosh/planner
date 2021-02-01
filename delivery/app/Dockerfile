FROM node:alpine

WORKDIR '/app'

COPY /app .
RUN npm install

RUN npm run build

FROM nginx
COPY --from=0 /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY ./delivery/nginx/nginx.conf /etc/nginx/conf.d
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]