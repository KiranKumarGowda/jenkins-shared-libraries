def build (String ProjectName , String ImageTag , String DockerHubUser)
{
  sh " Docker build -t ${DockerHubUser}/${ProjectName}/${ImageTag} "
}
