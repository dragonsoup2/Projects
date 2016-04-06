using Assign8.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assign8.Controllers
{
    public class ArtistAdd
    {
        public ArtistAdd()
        {
            MediaItems = new List<MediaItem>();
        }
        [Required]
        [StringLength(60)]
        [Display(Name = "Artist name or stage name")]
        public string Name { get; set; }

        [StringLength(60)]
        [Display(Name = "If applicable, artist's birth name")]
        public string BirthName { get; set; }

        [Display(Name = "Birth date, or start date")]
        [DataType(DataType.DateTime)]
        public DateTime BirthOrStartDate { get; set; }

        [Display(Name = "Arist's primary genre")]
        public string Genre { get; set; }

        [Display(Name = "URL to artist photo")]
        [StringLength(220)]
        public string UrlArtist { get; set; }

        public string Profile { get; set; }
        public IEnumerable<MediaItem> MediaItems { get; set; }
    }

    public class ArtistBase : ArtistAdd
    {
        [Key]
        public int Id { get; set; }

        [StringLength(60)]
        [Display(Name = "Executive who looks after this artist")]
        public string Executive { get; set; }
    }

    public class ArtistWithDetail : ArtistBase
    {
        [Display(Name ="Artist Profile")]
        public string Profile { get; set; }
    }

    public class ArtistAddForm
    {
        public ArtistAddForm()
        {
            BirthOrStartDate = DateTime.Now.AddYears(-25);
        }

        [Required]
        [StringLength(60)]
        [Display(Name = "Artist name or stage name")]
        public string Name { get; set; }

        [StringLength(60)]
        [Display(Name = "If applicable, artist's birth name")]
        public string BirthName { get; set; }

        [Display(Name = "Birth date, or start date")]
        [DataType(DataType.DateTime)]
        public DateTime BirthOrStartDate { get; set; }

        [Display(Name = "Arist's primary genre")]
        public SelectList GenreList { get; set; }

        [StringLength(220)]
        [DataType(DataType.ImageUrl)]
        [Display(Name = "URL to artist photo")]
        public string UrlArtist { get; set; }

        [DataType(DataType.MultilineText)]
        public string Profile { get; set; }


    }

    public class ArtistEdit
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(60)]
        public string Name { get; set; }

        [StringLength(60)]
        public string BirthName { get; set; }

        public DateTime? BirthOrStartDate { get; set; }

        public String Genre { get; set; }

        [StringLength(220)]
        public string UrlArtist { get; set; }

        [Required]
        [StringLength(60)]
        public string Executive { get; set; }
    }

    public class ArtistEditForm
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(60)]
        [Display(Name = "Artist name or stage name")]
        public string Name { get; set; }

        [StringLength(60)]
        [Display(Name = "If applicable, artist's birth name")]
        public string BirthName { get; set; }

        [Display(Name = "Birth date, or start date")]
        public DateTime? BirthOrStartDate { get; set; }

        [Display(Name = "Arist's primary genre")]
        public SelectList GenreList { get; set; }

        [StringLength(220)]
        [DataType(DataType.ImageUrl)]
        [Display(Name = "URL to artist photo")]
        public string UrlArtist { get; set; }

        [Required]
        [StringLength(60)]
        [Display(Name = "Executive who looks after this artist")]
        public string Executive { get; set; }

        [DataType(DataType.MultilineText)]
        public string Profile { get; set; }
    }

    public class ArtistWithMediaItemStringIds : ArtistBase
    {
        public ArtistWithMediaItemStringIds()
        {
            MediaItems = new List<MediaItemBase>();
        }

        public IEnumerable<MediaItemBase> MediaItems { get; set; }
    }
}