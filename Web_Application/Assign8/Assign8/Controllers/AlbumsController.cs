using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assign8.Controllers
{
    public class AlbumsController : Controller
    {
        private Manager m = new Manager();
        // GET: Albums
        public ActionResult Index()
        {
            return View(m.AlbumGetAll());
        }

        // GET: Albums/Details/5
        public ActionResult Details(int id)
        {
            return View(m.AlbumGetByIdWithDetail(id));
        }

        // GET: Albums/Create
        [Authorize(Roles = "Admin , Coordinator")]
        public ActionResult Create(int? id)
        {
            var form = new AlbumAddForm();

            form.ArtistList = new MultiSelectList
                (items: m.ArtistGetAll(),
                    dataValueField: "Id",
                    dataTextField: "Name"
                );
            form.TrackList = new MultiSelectList
                (
                    items: m.TrackGetAll(),
                    dataValueField: "Id",
                    dataTextField: "Name"
                );
            form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name");

            return View(form);
        }

        // POST: Albums/Create
        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Create(AlbumAdd newItem)
        {
            if (!ModelState.IsValid)
            {
                var form = Mapper.Map<AlbumAddForm>(newItem);

                form.ArtistList = new MultiSelectList
                (items: m.ArtistGetAll(),
                    dataValueField: "Id",
                    dataTextField: "Name",
                    selectedValues: newItem.ArtistIds
                );
                form.TrackList = new MultiSelectList
                (
                    items: m.TrackGetAll(),
                    dataValueField: "Id",
                    dataTextField: "Name",
                    selectedValues: newItem.TrackIds
                );

                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name", newItem.Genre);
                return View(form);
            }

            // Process the input
            var addedItem = m.AlbumAdd(newItem);

            if (addedItem == null)
            {
                var form = Mapper.Map<AlbumAddForm>(newItem);

                form.ArtistList = new MultiSelectList
                (items: m.ArtistGetAll(),
                    dataValueField: "Id",
                    dataTextField: "Name",
                    selectedValues: newItem.ArtistIds
                );
                form.TrackList = new MultiSelectList
                (
                    items: m.TrackGetAll(),
                    dataValueField: "Id",
                    dataTextField: "Name",
                    selectedValues: newItem.TrackIds
                );

                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name", newItem.Genre);
                return View(form);
            }
            else
            {
                // Attention - Must redirect to the controller
                return RedirectToAction("details", "albums", new { id = addedItem.Id });
            }
        }

        // GET: Albums/Create
        [Route("albums/{id}/addtrack")]
        [Authorize(Roles = "Admin , Clerk")]
        public ActionResult AddTrack(int? id)
        {
            var a = m.AlbumGetByIdWithDetail(id.GetValueOrDefault());

            if (a == null)
            {
                return HttpNotFound();
            }
            else
            {
                var form = new TrackAddForm();
                form.AlbumId = a.Id;
                form.AlbumName = a.Name;
                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name");

                return View(form);
            }
        }

        // POST: Albums/Create
        [Route("albums/{id}/addtrack")]
        [HttpPost]
        public ActionResult AddTrack(TrackAdd newItem)
        {
            var a = m.AlbumGetByIdWithDetail(newItem.AlbumId);

            if (!ModelState.IsValid)
            {
                var form = Mapper.Map<TrackAddForm>(newItem);

                form.AlbumId = a.Id;
                form.AlbumName = a.Name;
                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name", newItem.Genre);

                return View(form);
            }

            // Process the input
            var addedItem = m.TrackAdd(newItem);

            if (addedItem == null)
            {
                var form = Mapper.Map<TrackAddForm>(newItem);

                form.AlbumId = a.Id;
                form.AlbumName = a.Name;
                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name", newItem.Genre);

                return View(form);
            }
            else
            {
                // Attention - Must redirect to the controller
                return RedirectToAction("details", "tracks", new { id = addedItem.Id });
            }
        }
        // GET: Albums/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Albums/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Albums/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Albums/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
