def call(String ProjectName , String ImageTag , String DockerHubUser)
{
  sh " Docker build -t ${DockerHubUser}/${ProjectName}/${ImageTag} "
}
