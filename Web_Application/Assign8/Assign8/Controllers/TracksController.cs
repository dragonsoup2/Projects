using Assign8.Models;
using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assign8.Controllers
{
    public class TracksController : Controller
    {
        private ApplicationDbContext ds = new ApplicationDbContext();
        private Manager m = new Manager();
        // GET: Tracks
        public ActionResult Index()
        {
            return View(m.TrackGetAll());
        }

        // GET: Tracks/Details/5
        public ActionResult Details(int id)
        {
            var a = m.TrackGetByIdWithDetail(id);
            var o = m.TrackContentGetById(id);
            a.TrackUpload = o.ContentType;
            a.Path = "/" + a.Path;
            return View(a);
        }
        // GET: Artists/Create
        [Authorize(Roles = "Admin , Clerk")]
        public ActionResult Create()
        {
            var form = new TrackAddForm();
            form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name");

            return View(form);
        }

        // POST: Artists/Create
        [HttpPost]
        public ActionResult Create(TrackAdd newItem)
        {
            if (!ModelState.IsValid)
            {
                var form = Mapper.Map<TrackAddForm>(newItem);
                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name");

                return View(form);
            }

            // Process the input
            var addedItem = m.TrackAdd(newItem);

            if (addedItem == null)
            {

                var form = Mapper.Map<TrackAddForm>(newItem);
                form.GenreList = new SelectList(m.GenreGetAll(), "Name", "Name");

                return View(form);
            }
            else
            {
                return RedirectToAction("details", new { id = addedItem.Id });
            }
        }
        // GET: Tracks/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Tracks/Edit/5
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

        // GET: Tracks/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Tracks/Delete/5
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
