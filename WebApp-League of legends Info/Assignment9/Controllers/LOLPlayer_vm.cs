using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assignment9.Controllers
{
    public class LOLPlayerAdd
    {
        [Display(Name = "Team Code")]
        [Required, StringLength(100)]
        public string LOLTeamCode { get; set; }

        [Display(Name ="Nickname")]
        [Required, StringLength(100)]
        public string InGameName { get; set; }

        [Required, StringLength(100)]
        public string LastName { get; set; }

        [Required, StringLength(100)]
        public string FirstName { get; set; }

        [Display(Name = "Position")]
        [Required, StringLength(100)]
        public string Role { get; set; }
    }

    public class LOLPlayerBase : LOLPlayerAdd
    {
        public int Id { get; set; }

    }

    public class LOLPlayerWithDetail : LOLPlayerBase
    {
        public LOLTeamBase LOLTeam { get; set; }

    }
}