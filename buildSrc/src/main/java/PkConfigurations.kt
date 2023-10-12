import org.gradle.api.Project

object PkConfigurations {

    val targetEnvironment = Environment.TESTING.env

    fun org.gradle.api.internal.artifacts.Module.getTest(): String {
        return  ""
    }
    public val API_BASE_URL = {

        when(targetEnvironment){
            Environment.TESTING.env-> {
                "https://xprox.azurewebsites.net"
            }
            Environment.STAGING.env-> {
                "https://swinji-proxy.azurewebsites.net"
            }
            Environment.CS_STAGING.env-> {
                "https://proxy-staging.winjigo.com"
            }
            Environment.PRODUCTION.env-> {
                "https://proxy.winjigo.com"
            }
            Environment.INTEGRATION.env-> {
                "https://lms-proxy.moepilot.com"
            }
            else ->  "https://xwinji.azurewebsites.net"
        }

    }

    val WINJI_AUTH_URL = {
        when(targetEnvironment){
            Environment.TESTING.env-> {
                "https://xwinji.azurewebsites.net"
            }
            Environment.STAGING.env-> {
                "https://swinji.azurewebsites.net"
            }
            Environment.CS_STAGING.env-> {
                "https://learn-staging.winjigo.com"
            }
            Environment.PRODUCTION.env-> {
                "https://learn.winjigo.com"
            }
            Environment.INTEGRATION.env-> {
                "https://lms.moepilot.com"
            }
            else ->  "https://xwinji.azurewebsites.net"
        }
    }

    val AUTH_URL = {
        when(targetEnvironment){
            Environment.TESTING.env-> {
                "https://xeduidserver.azurewebsites.net"
            }
            Environment.STAGING.env-> {
                "https://staging-identity.azurewebsites.net"
            }
            Environment.CS_STAGING.env-> {
                "https://eduidserver.azurewebsites.net/en/identity/"
            }
            Environment.PRODUCTION.env-> {
                "https://eduidserver.azurewebsites.net"
            }
            Environment.INTEGRATION.env-> {
                "https://lms-identity.moepilot.com"
            }
            else ->  "https://xeduidserver.azurewebsites.net"
        }
    }
}
