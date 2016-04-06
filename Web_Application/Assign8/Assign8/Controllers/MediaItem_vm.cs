using Assign8.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assign8.Controllers
{

        public class MediaItemAdd
        {
            public int ArtistId { get; set; }

            // Brief descriptive caption
            [Required, StringLength(100)]
            public string Caption { get; set; }

            // Attention - 11 - In this "Form" class, the property type is HttpPostedFileBase, and the data type is upload
            [Required]
            public HttpPostedFileBase MediaItemUpload { get; set; }
        }
        public class MediaItemAddForm
        {
            public int ArtistId { get; set; }

            //[Display(Name = "Artist information")]
            //public string PropertyInfo { get; set; }

            // Brief descriptive caption
            [Display(Name = "Descriptive caption")]
            public string Caption { get; set; }

            // Attention - 09 - In this "Form" class, the Artist type is string, and the data type is upload
            // The DataType.Upload uses the Views > Shared > EditorTemplates > Upload.cshtml template
            [Required]
            [Display(Name = "Media Item")]
            [DataType(DataType.Upload)]
            public string MediaItemUpload { get; set; }
        }

        // Attention - 05 - View model class for MediaItem info (no MediaItem data/bytes)
        // Notice the presence of the identifying (Id, StringId) and descriptive data (Timestamp, Caption)
        public class MediaItemBase : MediaItemContent
        {
            public int Id { get; set; }

            [Display(Name = "Added on date/time")]
            public DateTime Timestamp { get; set; }

            // For the generated identifier
            [Required, StringLength(100)]
            [Display(Name = "Unique identifier")]
            public string StringId { get; set; }

            // Brief descriptive caption
            [Required, StringLength(100)]
            [Display(Name = "Descriptive caption")]
            public string Caption { get; set; }
        }

        // Attention - 07 - View model class for MediaItem data/bytes
        public class MediaItemContent
        {
            public int Id { get; set; }
            public string ContentType { get; set; }
            public byte[] Content { get; set; }
        }
}