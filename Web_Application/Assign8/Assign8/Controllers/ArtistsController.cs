using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Collections;

namespace Assign8.Controllers
{
    public class ArtistsController : Controller
    {
        private Manager m = new Manager();

        public IEnumerable Genres { get; private set; }

        // GET: Artists
        public ActionResult Index()
        {
            return View(m.ArtistGetAll());
        }

        // GET: Artists/Details/5
        public ActionResult Details(int id)
        {
            return View(m.ArtistGetByIdWithDetail(id));
        }
        public ActionResult DetailsWithMediaItemInfo(int? id)
        {
            // Attempt to get the matching object
            var o = m.ArtistGetByIdWithMediaItemInfo(id.GetValueOrDefault());

            if (o == null)
            {
                return HttpNotFound();
            }
            else
            {
                // Pass the object to the view
                return View(o);
            }
        }

        [Authorize(Roles = "Admin , Executive")]
        // GET: Artists/Create
        public ActionResult Create()
        {
            var form = new ArtistAddForm();
            form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name");

            return View(form);
        }

        // POST: Artists/Create
        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Create(ArtistAdd newItem)
        {
            if (!ModelState.IsValid)
            {
                var form = Mapper.Map<ArtistAddForm>(newItem);

                return View(form);
            }

            var addedItem = m.ArtistAdd(newItem);

            if (addedItem == null)
            {
                var form = Mapper.Map<ArtistAddForm>(newItem);
                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name", newItem.Genre);

                return View(form);
            }
            else
            {
                return RedirectToAction("details", new { id = addedItem.Id });
            }
        }

        [Authorize(Roles = "Admin , Coordinator, Manager, Intern")]
        [Route("artists/{id}/addalbum")]
        // GET: Albums/Create
        public ActionResult AddAlbum(int? id)
        {
            var a = m.ArtistGetByIdWithDetail(id.GetValueOrDefault());

            if (a == null)
            {
                return HttpNotFound();
            }
            else
            {
                var form = new AlbumAddForm();
                form.ArtistId = a.Id;
                form.ArtistName = a.Name;

                var selectedValueCollection = new List<int>();
                selectedValueCollection.Add(a.Id);

                form.ArtistList = new MultiSelectList
                    (items: m.ArtistGetAll(),
                        dataValueField: "Id",
                        dataTextField: "Name",
                        selectedValues: selectedValueCollection
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
        }

        // POST: Albums/Create
        [Route("artists/{id}/addalbum")]
        [HttpPost]
        public ActionResult AddAlbum(AlbumAdd newItem)
        {
            var a = m.ArtistGetByIdWithDetail(newItem.ArtistId);

            if (!ModelState.IsValid)
            {
                var form = Mapper.Map<AlbumAddForm>(newItem);

                form.ArtistId = a.Id;
                form.ArtistName = a.Name;

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

        [Authorize(Roles = "Admin, Coordinator")]
        [Route("artists/{id}/addmediaitem")]
        public ActionResult AddMediaItem(int? id)
        {
            // Attempt to get the matching object
            var o = m.ArtistGetById(id.GetValueOrDefault());

            if (o == null)
            {
                return HttpNotFound();
            }
            else
            {
                var form = new MediaItemAddForm();
                form.ArtistId = o.Id;

                return View(form);
            }
        }

        // POST: Properties/5/AddPhoto
        [HttpPost]
        [Route("artists/{id}/addmediaitem")]
        public ActionResult AddMediaItem(int? id, MediaItemAdd newItem)
        {
            if (!ModelState.IsValid && id.GetValueOrDefault() == newItem.ArtistId)
            {
                return View(newItem);
            }
            newItem.ArtistId = id.GetValueOrDefault();
            // Process the input
            var addedItem = m.ArtistMediaItemAdd(newItem);
            //return Content(newItem.ArtistId + "");
            if (addedItem == null)
            {
                //return Content("here");
                return View(newItem);
            }
            else
            {
                return RedirectToAction("Details", new { id = addedItem.Id });
            }
        }

        [Authorize(Roles = "Admin , Executive, Manager, Intern")]
        public ActionResult Edit(int? id)
        {
            var o = m.ArtistGetByIdWithDetail(id.GetValueOrDefault());

            if (o.Executive == User.Identity.Name || User.IsInRole("Admin") || User.IsInRole("Manager") || User.IsInRole("Intern"))
            {
                if (o == null)
                {
                    return HttpNotFound();
                }
                else
                {              
                    var form = AutoMapper.Mapper.Map<ArtistEditForm>(o);
                    form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name", o.Genre);

                    return View(form);
                }
            }
            else
            {
                return RedirectToAction("index");
            }
        }

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Edit(int? id, ArtistEdit newItem)
        {
            if (!ModelState.IsValid)
            {
                return RedirectToAction("edit", new { id = newItem.Id });
            }

            if (id.GetValueOrDefault() != newItem.Id)
            {
                return RedirectToAction("index");
            }

            var editedItem = m.ArtistEdit(newItem);

            if (editedItem == null)
            {
                return RedirectToAction("edit", new { id = newItem.Id });
            }
            else
            {
                return RedirectToAction("details", new { id = newItem.Id });
            }
        }
        // GET: Artists/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Artists/Delete/5
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
