using Assign8.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assign8.Controllers
{
    public class TrackAdd
    {
        [Required]
        [StringLength(200)]
        public string Name { get; set; }

        [StringLength(220)]
        public string Composers { get; set; }

        [StringLength(120)]
        public string Genre { get; set; }

        public int AlbumId { get; set; }
        [Required]
        public HttpPostedFileBase TrackUpload { get; set; }
        public string Path { get; set; }

    }

    public class TrackBase : TrackAdd
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(60)]
        [Display(Name = "Clerk who looks after this artist")]
        public string Clerk { get; set; }
    }

    public class TrackWithDetail : TrackBase
    {
        public TrackWithDetail()
        {
            AlbumNames = new List<String>();
        }

        [Display(Name = "Number of albums with this track")]
        public int AlbumCount { get; set; }

        [Display(Name = "Sample Clip")]
        public string TrackUpload { get; set; }

        public IEnumerable<String> AlbumNames { get; set; }
    }

    public class TrackAddForm
    {
        [Required]
        [StringLength(200)]
        [Display(Name = "Track name")]
        public string Name { get; set; }

        [StringLength(220)]
        [Display(Name = "Composer names (comma-seperated)")]
        public string Composers { get; set; }

        [Display(Name = "Album's primary genre")]
        public SelectList GenreList { get; set; }

        public int AlbumId { get; set; }
        public string AlbumName { get; set; }

        [Required]
        [Display(Name = "Track Clip")]
        [DataType(DataType.Upload)]
        public string TrackUpload { get; set; }
    }

    public class TrackEdit
    {
        [Required]
        [StringLength(200)]
        public string Name { get; set; }

        [StringLength(220)]
        public string Composers { get; set; }

        [StringLength(120)]
        public string Genre { get; set; }
    }

    public class TrackEditForm
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(200)]
        [Display(Name = "Track name")]
        public string Name { get; set; }

        [StringLength(220)]
        [Display(Name = "Composer names (comma-seperated)")]
        public string Composers { get; set; }

        [Display(Name = "Album's primary genre")]
        public SelectList GenreList { get; set; }

        public int AlbumId { get; set; }
        public string AlbumName { get; set; }
    }

    public class TrackContent
    {
        public int Id { get; set; }
        public string ContentType { get; set; }
        public byte[] Content { get; set; }
    }
}