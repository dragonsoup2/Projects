using Assignment9.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assignment9.Controllers
{
    public class LOLTeamAdd
    {
        public LOLTeamAdd()
        {
            CreatedDate = DateTime.Now.AddYears(-1);
        }

        [Required, StringLength(100)]
        public string Name { get; set; }

        [Required, StringLength(100)]
        public string Code { get; set; }
        public DateTime CreatedDate { get; set; }

        [Required, StringLength(100)]
        public string Sponsor { get; set; }

        [Required, StringLength(100)]
        public string CoachFirstName { get; set; }

        [Required, StringLength(100)]
        public string CoachLastName { get; set; }
        public string Logo { get; set; }
        public int Rank { get; set; }
    }

    public class LOLTeamBase : LOLTeamAdd
    {
        [Key]
        public int Id { get; set; }

    }

    public class LOLTeamWithDetail : LOLTeamBase
    {
        public LOLTeamWithDetail()
        {
            Players = new List<LOLPlayer>();
        }

        public IEnumerable<LOLPlayer> Players { get; set; }
        public int PlayersCount { get; set; }
        public SponsorBase Sponsor { get; set; }

    }
}