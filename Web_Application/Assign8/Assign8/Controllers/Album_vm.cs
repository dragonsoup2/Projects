using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assign8.Controllers
{
    public class AlbumAdd
    {
        public AlbumAdd()
        {
            TrackIds = new List<int>();
            ArtistIds = new List<int>();
        }
        [Required]
        [StringLength(160)]
        [Display(Name = "Album name")]
        public string Name { get; set; }

        [Display(Name = "Release date")]
        public DateTime ReleaseDate { get; set; }

        [Display(Name = "Album image (cover art)")]
        [StringLength(220)]
        public string UrlAlbum { get; set; }

        [Display(Name = "Album's primary genre")]
        [StringLength(120)]
        public string Genre { get; set; }
        public string Description { get; set; }
        public int ArtistId { get; set; }
        public IEnumerable<int> ArtistIds { get; set; }
        public IEnumerable<int> TrackIds { get; set; }
    }

    public class AlbumBase : AlbumAdd
    {
        [Key]
        public int Id { get; set; }

        [StringLength(60)]
        [Display(Name = "Coordinator who looks after this artist")]
        public string Coordinator { get; set; }
    }

    public class AlbumWithDetail : AlbumBase
    {
        public AlbumWithDetail()
        {
            Artists = new List<ArtistBase>();
            Tracks = new List<TrackBase>();
        }
        public IEnumerable<ArtistBase> Artists { get; set; }
        public IEnumerable<TrackBase> Tracks { get; set; }
        [Display(Name = "Description of Album")]
        public string Description { get; set; }
    }

    public class AlbumAddForm
    {
        public AlbumAddForm()
        {
            ReleaseDate = DateTime.Now;
        }

        [Required]
        [StringLength(160)]
        [Display(Name = "Album name")]
        public string Name { get; set; }

        [Display(Name = "Release date")]
        public DateTime ReleaseDate { get; set; }

        [DataType(DataType.ImageUrl)]
        [StringLength(220)]
        [Display(Name = "URL to album image (cover art)")]
        public string UrlAlbum { get; set; }

        [Display(Name = "Album's primary genre")]
        public SelectList GenreList { get; set; }

        [Display(Name = "All artists")]
        public MultiSelectList ArtistList { get; set; }

        [Display(Name = "All tracks")]
        public MultiSelectList TrackList { get; set; }

        [Range(1, Int32.MaxValue)]
        public int ArtistId { get; set; }

        public string ArtistName { get; set; }

        [DataType(DataType.MultilineText)]
        public string Description { get; set; }
    }

    public class AlbumEdit
    {
        public AlbumEdit()
        {
            ArtistIds = new List<int>();
            TrackIds = new List<int>();
        }
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(160)]
        public string Name { get; set; }

        public DateTime? ReleaseDate { get; set; }

        [DataType(DataType.ImageUrl)]
        [StringLength(220)]
        public string UrlAlbum { get; set; }

        [StringLength(120)]
        public string Genre { get; set; }

        [Required]
        [StringLength(60)]
        public string Coordinator { get; set; }

        public IEnumerable<int> ArtistIds { get; set; }
        public IEnumerable<int> TrackIds { get; set; }
    }

    public class AlbumEditForm
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(160)]
        [Display(Name = "Album name")]
        public string Name { get; set; }

        [Display(Name = "Release date")]
        public DateTime? ReleaseDate { get; set; }

        [DataType(DataType.ImageUrl)]
        [StringLength(220)]
        [Display(Name = "URL to album image (cover art)")]
        public string UrlAlbum { get; set; }

        [Display(Name = "Album's primary genre")]
        public SelectList GenreList { get; set; }

        [Display(Name = "All artists")]
        public MultiSelectList ArtistList { get; set; }

        [Display(Name = "All tracks")]
        public MultiSelectList TrackList { get; set; }

        [Required]
        [StringLength(60)]
        [Display(Name = "Executive who looks after this artist")]
        public string Coordinator { get; set; }

        public string ArtistName { get; set; }

        [DataType(DataType.MultilineText)]
        public string Description { get; set; }
    }
}