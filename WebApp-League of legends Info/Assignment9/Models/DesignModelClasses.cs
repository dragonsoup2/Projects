using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// new...
using System.ComponentModel.DataAnnotations;

namespace Assignment9.Models
{
    // Add your design model classes below

    // Follow these rules or conventions:

    // To ease other coding tasks, the name of the 
    //   integer identifier property should be "Id"
    // Collection properties (including navigation properties) 
    //   must be of type ICollection<T>
    // Valid data annotations are pretty much limited to [Required] and [StringLength(n)]
    // Required to-one navigation properties must include the [Required] attribute
    // Do NOT configure scalar properties (e.g. int, double) with the [Required] attribute
    // Initialize DateTime and collection properties in a default constructor

    public class LOLTeam
    {
        public LOLTeam()
        {
            CreatedDate = DateTime.Now.AddYears(-1);
            Players = new List<LOLPlayer>();
        }
        public int Id { get; set; }

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
        public ICollection<LOLPlayer> Players { get; set; }

    }

    public class LOLPlayer
    {
        public int Id { get; set; }

        [Required, StringLength(100)]
        public string LOLTeamCode { get; set; }

        [Required, StringLength(100)]
        public string InGameName { get; set; }

        [Required, StringLength(100)]
        public string LastName { get; set; }

        [Required, StringLength(100)]
        public string FirstName { get; set; }

        [Required, StringLength(100)]
        public string Role { get; set; }
        public LOLTeam LOLTeam { get; set; }


    }

    public class Sponsor
    {
        public int Id { get; set; }

        [Required, StringLength(100)]
        public string CompanyName { get; set; }

        [Required, StringLength(100)]
        public string Job { get; set; }
        public LOLTeam LOLTeam { get; set; }


    }

    public class RoleClaim
    {
        public int Id { get; set; }

        [Required, StringLength(100)]
        public string Name { get; set; }
    }

}
