using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assignment9.Controllers
{
    public class SponsorAdd
    {
        [Display(Name = "Name of Company")]
        [Required, StringLength(100)]
        public string CompanyName { get; set; }

        [Display(Name = "Type of Job")]
        [Required, StringLength(100)]
        public string Job { get; set; }
    }

    public class SponsorBase : SponsorAdd
    {
        public int Id { get; set; }
    }

    public class SponsorWithDetail : SponsorBase
    {
        [Display(Name = "Sponsoring LOL Team")]
        public LOLTeamBase LOLTeam { get; set; }
    }
}