using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Assign8.Startup))]
namespace Assign8
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
