using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// new...
using AutoMapper;

namespace Assignment9
{
    public static class AutoMapperConfig
    {
        public static void RegisterMappings()
        {
            // Add map creation statements here
            // Mapper.CreateMap< FROM , TO >();

            // Disable AutoMapper v4.2.x warnings
#pragma warning disable CS0618
            // Add more below...
            Mapper.CreateMap<Models.RegisterViewModel, Models.RegisterViewModelForm>();

            Mapper.CreateMap<Models.LOLTeam, Controllers.LOLTeamBase>();
            Mapper.CreateMap<Models.LOLTeam, Controllers.LOLTeamWithDetail>();
            Mapper.CreateMap<Models.LOLTeam, Models.LOLPlayer>();
            Mapper.CreateMap<Controllers.LOLTeamAdd, Models.LOLTeam>();

            Mapper.CreateMap<Models.LOLPlayer, Controllers.LOLPlayerBase>();
            Mapper.CreateMap<Models.LOLPlayer, Controllers.LOLPlayerWithDetail>();
            Mapper.CreateMap<Models.LOLPlayer, Models.LOLTeam>();
            Mapper.CreateMap<Controllers.LOLPlayerAdd, Models.LOLPlayer>();

            Mapper.CreateMap<Models.Sponsor, Controllers.SponsorBase>();
            Mapper.CreateMap<string, Controllers.SponsorBase>();
            Mapper.CreateMap<Models.Sponsor, Controllers.SponsorWithDetail>();
            Mapper.CreateMap<Controllers.SponsorAdd, Models.Sponsor>();




#pragma warning restore CS0618
        }
    }
}