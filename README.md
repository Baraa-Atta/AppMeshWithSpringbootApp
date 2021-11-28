# AppMeshWithSpringbootApp
  To run the project you need to do the following:
  
  1) Download minikube and kubectl, you can find the links here https://kubernetes.io/docs/tasks/tools/
  2) Download docker from this link https://www.docker.com/products/docker-desktop
  3) Download helm from this link https://helm.sh/docs/intro/install/
  4) Open command line then add helm charts with this command: **helm repo add eks https://aws.github.io/eks-charts**
  5) Start minikube with kubernetes version v1.21.2 with the command: **minikube start --kubernetes-version v1.21.2**
  6) Add docker enviroment to minikube to be able to pull local images with these two commands:\
      - **minikube docker-env**\
      - **@FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env') DO @%i**
  8) Install app mesh custom resources definitions with the command: **kubectl apply -k "https://github.com/aws/eks-charts/stable/appmesh-controller/crds?ref=master"**
  9) Navigate to the root of the project and build it while ignoring tests with the command: **mvn clean install -Dmaven.test.skip=true**
  10) Build docker image: **docker build -t aerospiketest:1 .**
  11) Navigate to the resources file **src/main/resources**
  12) The the image in kubernetes and integrate app mesh with kubernetes by running following commands:
      - kubectl apply -f namespace.yml
      - kubectl apply -f mesh.yml
      - kubectl apply -f database_virtual_node
      - kubectl apply -f database_virtual_service
      - kubectl apply -f database.yml
      - For current time you need to hardcode the IP of the database service in aerospikeconfigmap.yml which can be taken as folloowing
        - **kubectl get svc -n my-apps** Note, my-apps is the namespace
        - Then copy cluster IP of the database service and add it to url in aerospikeconfigmapfile.yml file.
      - kubectl apply -f aerospikeconfigmap.yml
      - kubectl apply -f app_virtual_node.yml
      - kubectl apply -f app_virtual_service.yml
      - kubectl apply -f app_virtual_router.yml
      - kubectl apply -f deployment.yml
  13) Minikube doesn't provide an External IP, but it has a similar way which can be done as following:
      - Open another terminal
      - Run the command **minikube service appservice** Note, appservice is the load balancer service name.
      - Now you can use the second URL that will be shown to connect to the API
  14) Open postman, there are two endpoints one for adding a new user and one for getting a user with a specified ID. The following is an example
      - To add a user send post request to **/users** with a JSON object as this one\
        {\
          "id": 1,\
          "name": "Mohammed",\
          "email": "moh@gmail.com",\
          "age": 20\
        }
      - To get a user with specified ID send a get request to **/users/{ID}**
  
