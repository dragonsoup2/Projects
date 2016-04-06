using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// new...
using AutoMapper;

namespace Assign8
{
    public static class AutoMapperConfig
    {
        public static void RegisterMappings()
        {
            // Add map creation statements here
            // Mapper.CreateMap< FROM , TO >();

            // Mappers for use case: add and edit
            Mapper.CreateMap<Models.Genre, Controllers.GenreBase>();


            Mapper.CreateMap<Models.Artist, Controllers.ArtistWithDetail>();
            Mapper.CreateMap<Models.Artist, Controllers.ArtistAddForm>();
            Mapper.CreateMap<Models.Artist, Controllers.ArtistBase>();
            Mapper.CreateMap<Controllers.ArtistAdd, Models.Artist>();
            Mapper.CreateMap<Controllers.ArtistAddForm, Controllers.ArtistAdd>();
            Mapper.CreateMap<Controllers.ArtistAdd, Controllers.ArtistAddForm>();
            Mapper.CreateMap<Controllers.ArtistAdd, Controllers.ArtistAddForm>();
            Mapper.CreateMap<Controllers.ArtistEdit, Controllers.ArtistEditForm>();
            Mapper.CreateMap<Controllers.ArtistEditForm, Controllers.ArtistEdit>();
            Mapper.CreateMap<Controllers.ArtistWithDetail, Controllers.ArtistEditForm>();

            Mapper.CreateMap<Controllers.AlbumAdd, Models.Album>();
            Mapper.CreateMap<Models.Album, Controllers.AlbumAddForm>();
            Mapper.CreateMap<Models.Album, Controllers.AlbumBase>();
            Mapper.CreateMap<Models.Album, Controllers.AlbumWithDetail>();
            Mapper.CreateMap<Controllers.AlbumAdd, Controllers.AlbumAddForm>();
            Mapper.CreateMap<Controllers.AlbumEdit, Controllers.AlbumEditForm>();
            Mapper.CreateMap<Controllers.AlbumWithDetail, Controllers.AlbumEditForm>();


            Mapper.CreateMap<Models.Track, Controllers.TrackBase>();
            Mapper.CreateMap<Models.Track, Controllers.TrackWithDetail>();
            Mapper.CreateMap<Controllers.TrackAdd, Controllers.TrackAddForm>();
            Mapper.CreateMap<Models.Track, Controllers.TrackAddForm>();
            Mapper.CreateMap<Controllers.TrackAdd, Models.Track>();
            Mapper.CreateMap<Models.Track, Controllers.TrackBase>();
            Mapper.CreateMap<Controllers.TrackWithDetail, Controllers.TrackContent>();
            Mapper.CreateMap<Models.Track, Controllers.TrackContent>();

            Mapper.CreateMap<Models.MediaItem, Controllers.MediaItemBase>();
            Mapper.CreateMap<Models.MediaItem, Controllers.MediaItemContent>();
            Mapper.CreateMap<Models.Artist, Controllers.ArtistWithMediaItemStringIds>();

            // Disable AutoMapper v4.2.x warnings
#pragma warning disable CS0618

            // Attention - AutoMapper create map statements




#pragma warning restore CS0618
        }
    }
}